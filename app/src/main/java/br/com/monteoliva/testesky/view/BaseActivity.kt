package br.com.monteoliva.testesky.view

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import br.com.monteoliva.testesky.R

/**
 * Basic Activity
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
abstract class BaseActivity(resourceView: Int) : AppCompatActivity(resourceView) {
    private var actionBar: ActionBar? = null
    private var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews(savedInstanceState)
        initViewModel()
    }

    fun animLeftToRight() { overridePendingTransition(R.anim.lefttoright, R.anim.stable) }
    fun animRightToLeft() { overridePendingTransition(R.anim.righttoleft, R.anim.stable) }

    fun setupToolBar(resource: Int) {
        mToolbar = findViewById(resource)
        setSupportActionBar(mToolbar)
        actionBar = supportActionBar
    }

    fun setActionBarHome()       { actionBar?.setHomeButtonEnabled(true) }
    fun setActionBarHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(true) }

    fun setActionBarNotHome()       { actionBar?.setHomeButtonEnabled(false) }
    fun setActionBarNotHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(false) }

    fun setActionBarTitle(title: String) { actionBar?.title = title }
    fun setActionBarTitle(title: Int)    { actionBar?.title = getString(title) }

    fun setActionBarSubTitle(title: String) { actionBar?.subtitle = title }
    fun setActionBarSubTitle(title: Int)    { actionBar?.subtitle = getString(title) }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            back(0)
            true
        }
        else {
            super.onKeyDown(keyCode, event)
        }
    }

    fun msgBox(msg: String) {
        AlertDialog.Builder(this, R.style.AlertDialogTheme)
            .apply {
                setTitle(R.string.btn_error)
                setMessage(msg)
                setCancelable(false)
                setPositiveButton("OK") { dialog1: DialogInterface?, whichButton: Int -> {} }
                create().show()
            }
    }

    abstract fun initViews(bundle: Bundle?)
    abstract fun initViewModel()
    abstract fun back(resultCode: Int)
}