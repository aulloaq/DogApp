package cl.aulloa.dogapp.ui.home

import cl.aulloa.dogapp.network.response.DogResponse

interface HomeContract {
    interface View{
        fun loadDogList(list: List<String>?)
    }
    interface Presenter{
        fun onCreate()
        fun goToDogDetail(name: String)
    }
    interface Interactor{
        fun searchDogList()
    }
    interface InteractorOutput{
        fun searchDogListResponse(dogResponse: DogResponse?)
    }
    interface Router{
        fun goToDetail(name: String)
    }
}