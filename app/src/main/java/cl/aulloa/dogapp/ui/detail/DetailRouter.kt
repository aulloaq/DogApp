package cl.aulloa.dogapp.ui.detail

import android.app.Activity
import android.content.Intent
import cl.aulloa.dogapp.ui.home.HomeActivity

class DetailRouter(val activity: Activity) : DetailContract.Router {
    override fun goToDogList() {
        activity.startActivity(Intent(activity, HomeActivity::class.java))
        activity.finishAffinity()
    }
}