package com.task.watch.ui.details
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.task.watch.R
import com.task.watch.data.api.models.Movie
import com.task.watch.databinding.ActivityDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

private const val INTENT_EXTRA_MOVIE = "movie"

class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailFragmentViewModel by viewModel {

        parametersOf(
            intent?.extras?.getParcelable(INTENT_EXTRA_MOVIE) ?: Movie()
        )
    }
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        //initViewPager()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMovieDetails()
    }

    companion object {
        private const val TAG = "DetailActivity"
        fun getIntent(movie: Movie, context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_MOVIE, movie)
            return intent
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.cancelRequest()
    }
}
