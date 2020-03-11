package men.ngopi.zain.mvvm_rx.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import men.ngopi.zain.mvvm_rx.App
import men.ngopi.zain.mvvm_rx.data.source.Repository
import men.ngopi.zain.mvvm_rx.data.source.local.entity.Status
import men.ngopi.zain.mvvm_rx.databinding.ActivityMainBinding
import men.ngopi.zain.mvvm_rx.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: Repository

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        val mainViewModel: MainViewModel by viewModels {
            ViewModelFactory(repository, this)
        }

        mainViewModel.getFlowableUsers().observe(this) {
            when (it.status) {
                Status.SUCCESS ->
                    it.data?.size?.let { size ->
                        Toast.makeText(this, size.toString(), Toast.LENGTH_SHORT).show()
                    }
                Status.LOADING ->
                    Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
