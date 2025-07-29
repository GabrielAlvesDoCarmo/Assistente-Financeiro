package br.com.gds.assistentefinanceiro.utils.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.nextActivity(activity: AppCompatActivity) {
    Intent(this@nextActivity, activity::class.java).apply {
        startActivity(this)
    }
}