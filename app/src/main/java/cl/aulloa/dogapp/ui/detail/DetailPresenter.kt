package cl.aulloa.dogapp.ui.detail

import android.app.Activity
import android.content.Intent
import cl.aulloa.dogapp.network.response.DogResponse
import cl.aulloa.dogapp.util.NAME

class DetailPresenter(val activity: DetailContract.View) : DetailContract.Presenter, DetailContract.InteractorOutput {
    private val interactor: DetailContract.Interactor = DetailInteractor(this)
    private val router: DetailContract.Router = DetailRouter(activity as Activity)
    override fun onCreate(intent: Intent?) {
        val dogName = intent?.getStringExtra(NAME) as String

        interactor.searchDogImages(dogName)
    }

    override fun goToDogList() {
        router.goToDogList()
    }

    override fun searchDogImagesResponse(body: DogResponse?) {
        activity.loadImages(body?.message)
    }
}