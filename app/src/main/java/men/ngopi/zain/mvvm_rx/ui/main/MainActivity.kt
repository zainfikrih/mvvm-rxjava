package men.ngopi.zain.mvvm_rx.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import men.ngopi.zain.mvvm_rx.R
import men.ngopi.zain.mvvm_rx.data.source.local.entity.Status

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel by viewModels()

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
