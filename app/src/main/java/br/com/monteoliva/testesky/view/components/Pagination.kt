package br.com.monteoliva.testesky.view.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

import br.com.monteoliva.testesky.R

/**
 * Pagination Class (Object)
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class Pagination(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private lateinit var paginacao: LinearLayout

    private var imgOFF: Drawable? = null
    private var imgON: Drawable? = null

    private var posicaoAtual: Int = 0
    private var posicaoOld: Int = 0

    init {
        initViews()
    }

    private fun initViews() {
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))

        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        inflater.inflate(R.layout.pagination, this).apply {
            paginacao = findViewById(R.id.pagination)
        }

        imgOFF = ContextCompat.getDrawable(context, R.drawable.ic_off)
        imgON  = ContextCompat.getDrawable(context, R.drawable.ic_on )

        clear()
    }

    private fun clear() {
        posicaoAtual = 0
        posicaoOld   = 0

        paginacao.removeAllViews()
    }

    fun addPagination(size: Int?) {
        clear()
        for (ii in 0 until size!!) { add(ii) }
    }

    private fun add(position: Int) {
        val ponto = ImageView(context).apply {
            id = position
            isClickable = false
            setPadding(7, 0, 7, 0)
            setImageDrawable(imgOFF)
        }
        paginacao.addView(ponto)
    }

    fun position(row: Int) {
        posicaoOld   = posicaoAtual
        posicaoAtual = row

	paginacao.apply {
            findViewById<ImageView>(posicaoOld).setImageDrawable(imgOFF)
            findViewById<ImageView>(posicaoAtual).setImageDrawable(imgON)
        }
    }
}