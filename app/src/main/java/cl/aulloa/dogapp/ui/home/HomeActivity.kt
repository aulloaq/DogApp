package cl.aulloa.dogapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.aulloa.dogapp.R

class HomeActivity : AppCompatActivity(), HomeContract.View, OnClick {
    lateinit var recyclerView: RecyclerView
    lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setActionBar()
        presenter = HomePresenter(this)
        presenter.onCreate()
    }

    fun setActionBar(){
        val actionbar = supportActionBar
        actionbar!!.title = "Dogs List"
    }

    override fun loadDogList(list: List<String>?) {
        recyclerView = findViewById<RecyclerView>(R.id.dogList).apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            adapter = list?.let { HomeAdapter(it, this@HomeActivity) }
        }
    }

    override fun click(name: String) {
        presenter.goToDogDetail(name)
    }
}

