package br.com.monteoliva.testesky.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

import br.com.monteoliva.testesky.R

/**
 * Progress Class (Object)
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class Progress(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    lateinit var view: View
    lateinit var textView: TextView

    init {
        initViews()
    }

    private fun initViews() {
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        view = inflater.inflate(R.layout.progress, this)

        textView = view.findViewById(R.id.txtProgress)
    }

    fun show() { view.visibility = View.VISIBLE }
    fun hide() { view.visibility = View.GONE    }

    fun setText(msg: String) { textView.text = msg }
    fun setText(msg: Int)    { textView.text = context.getString(msg) }
}