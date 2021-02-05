package cl.aulloa.dogapp.ui.home

import android.util.Log
import cl.aulloa.dogapp.network.RestClient
import cl.aulloa.dogapp.network.response.DogResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeInteractor(private val interactorOutput: HomeContract.InteractorOutput) : HomeContract.Interactor {

    override fun searchDogList() {
        val dogList = RestClient.instance.searchDogList()
        dogList.enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful)
                    interactorOutput.searchDogListResponse(response.body())
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                t.message?.let { Log.e("OnFailure", it) }
            }
        })
    }

}