package cl.aulloa.dogapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.aulloa.dogapp.R
import cl.aulloa.dogapp.ui.home.HomeActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer("Waiting", false).schedule(2000) {
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        }
    }
}