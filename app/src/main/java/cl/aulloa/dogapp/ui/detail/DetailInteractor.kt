package cl.aulloa.dogapp.ui.detail

import cl.aulloa.dogapp.network.RestClient
import cl.aulloa.dogapp.network.response.DogResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailInteractor(val interactorOutput: DetailContract.InteractorOutput) : DetailContract.Interactor {
    override fun searchDogImages(dogName: String) {
        val dogImages = RestClient.instance.searchDogImages(dogName)
        dogImages.enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful)
                    interactorOutput.searchDogImagesResponse(response.body())
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}