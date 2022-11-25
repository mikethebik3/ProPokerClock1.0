package no.michaebr.hiof.propokerclock10

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import java.util.*


class MainFragment : Fragment() {

    var mbuttonInnstillinger: Button? = null
    var mbuttonAvgStack: Button? = null
    private var _binding: MainFragment? = null
    private val binding get() = _binding!!
    var mTextViewCountDown: TextView? = null
    var mButtonStartPause: Button? = null
    var mCountDownTimer: CountDownTimer? = null
    var mTimerRunning = false
    lateinit var smallBlindBtn: TextView
    lateinit var bigBlindBtn: TextView
    var mTimeLeftInMillis: Long = 0



    //Oppretter Views
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_main, container, false)
        //Initaliserer views
        mbuttonInnstillinger = root.findViewById(R.id.button_innstilinger)
        mbuttonAvgStack = root.findViewById(R.id.button_avg_stack)
        mTextViewCountDown = root.findViewById(R.id.text_view_countdown)
        mButtonStartPause = root.findViewById(R.id.button_start_pause)
        smallBlindBtn = root.findViewById(R.id.small_blnd_txt)
        bigBlindBtn = root.findViewById(R.id.big_blnd_txt)
        mTimeLeftInMillis = START_TIME_IN_MILLIS

        //Metode hvor vi setter start tidspunkt i minutter
        updateCountDownText()

        mbuttonInnstillinger?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment3_to_blindsFragment)

        }

        mbuttonAvgStack?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment3_to_avgStackFragment)

        }

        //Oppretter clickListener med start knapp
        mButtonStartPause?.setOnClickListener {

            //Hvis mTimerRunning = true så må vi pause eller så må vi starte den
            if (mTimerRunning) {

                //Metode for å pause timeren
                pauseTimer()
            } else {

                //Metode for å starte timeren
                startTimer()
            }
        }
        return root
    }



    fun startTimer() {

        //Lager en ny instans av CountDownTimer//
        //OnTick kalles etter hvert sekund
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                //millisUntilFinished er tid som gjenstår i millisekunder
                //Oppdaterer countDownTimer textView til nåværende tid
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            //Metode som kalles på når tiden går ut, oppdaterer small og big blind verdier for så å resete timer
            override fun onFinish() {
                updateSmallAndBigButtons()
                resetTimer()
            }
        }.start()
        //Når timeren starter vil mTimerRunning være true også oppdateres start og pause text på knappen etter dette
        mTimerRunning = true
        updateButtons()
    }

    fun updateSmallAndBigButtons() {
        val smallBlind = smallBlindBtn!!.text.toString().toInt()
        val bigBlind = bigBlindBtn!!.text.toString().toInt()
        val smallUpdateBlind = smallBlind * 2
        val bigUpdateBlind = bigBlind * 2
        smallBlindBtn!!.text = smallUpdateBlind.toString() + ""
        bigBlindBtn!!.text = bigUpdateBlind.toString() + ""
    }

    fun pauseTimer() {
        mCountDownTimer!!.cancel()
        mTimerRunning = false
        updateButtons()
    }

    fun resetTimer() {
        updateButtons()
        mTimeLeftInMillis = START_TIME_IN_MILLIS
        updateCountDownText()
        startTimer()
    }

    fun updateCountDownText() {
        //Konverterer millisekunder til minutter
        val minutes = (mTimeLeftInMillis / 1000).toInt() / 60

        //Konverterer millisekunder til sekunder
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60

        //Formaterer minutter og sekunder
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)

        //Setter formatert tid til textView
        mTextViewCountDown!!.text = timeLeftFormatted
    }

    fun updateButtons() {
        if (mTimerRunning) {
            mButtonStartPause!!.text = "Pause"
        } else {
            mButtonStartPause!!.text = "Start"
            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause!!.visibility = View.INVISIBLE
            } else {
                mButtonStartPause!!.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        //Kansellerer countDownTimer onDestroy() for å forhindre memory leaks
        if (mCountDownTimer != null) {
            mCountDownTimer!!.cancel()
        }
    }

    companion object {

        private const val START_TIME_IN_MILLIS: Long = 600000
    }
}