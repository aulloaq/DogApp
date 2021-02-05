package cl.aulloa.dogapp.ui.detail

import android.content.Intent
import cl.aulloa.dogapp.network.response.DogResponse

interface DetailContract {
    interface View{
        fun loadImages(list: List<String>?)
    }
    interface Presenter{
        fun onCreate(intent: Intent?)
        fun goToDogList()
    }
    interface Interactor{
        fun searchDogImages(dogName: String)
    }
    interface InteractorOutput{
        fun searchDogImagesResponse(body: DogResponse?)
    }
    interface Router{
        fun goToDogList()
    }
}