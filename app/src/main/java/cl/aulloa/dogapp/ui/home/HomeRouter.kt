package cl.aulloa.dogapp.ui.home

import android.app.Activity
import android.content.Intent
import cl.aulloa.dogapp.ui.detail.DetailActivity
import cl.aulloa.dogapp.util.NAME

class HomeRouter(val activity: Activity) : HomeContract.Router {
    override fun goToDetail(name: String) {
        activity.startActivity(Intent(activity, DetailActivity::class.java).putExtra(NAME, name))
        activity.finishAffinity()
    }
}