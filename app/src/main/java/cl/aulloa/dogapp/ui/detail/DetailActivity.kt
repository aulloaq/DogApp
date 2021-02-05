package cl.aulloa.dogapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.aulloa.dogapp.R

class DetailActivity : AppCompatActivity(), DetailContract.View {
    lateinit var recyclerView: RecyclerView
    lateinit var presenter: DetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setActionBar()
        presenter = DetailPresenter(this)
        presenter.onCreate(intent)
    }

    override fun loadImages(list: List<String>?) {
        recyclerView = findViewById<RecyclerView>(R.id.dogImagesList).apply {
            layoutManager = GridLayoutManager(this@DetailActivity, 4, GridLayoutManager.VERTICAL, false)
            adapter = list?.let { DetailAdapter(this@DetailActivity, it) }
        }
    }

    fun setActionBar(){
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Dog Images"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        presenter.goToDogList()
    }
}