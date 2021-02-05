package cl.aulloa.dogapp.ui.home

import android.app.Activity
import cl.aulloa.dogapp.network.response.DogResponse

class HomePresenter(private val activity: HomeContract.View) : HomeContract.Presenter, HomeContract.InteractorOutput {

    private val interactor: HomeContract.Interactor = HomeInteractor(this)
    private val router: HomeContract.Router = HomeRouter(activity as Activity)

    override fun onCreate() {
        interactor.searchDogList()
    }

    override fun goToDogDetail(name: String) {
        router.goToDetail(name)
    }

    override fun searchDogListResponse(dogResponse: DogResponse?) {
        activity.loadDogList(dogResponse?.message)
    }
}