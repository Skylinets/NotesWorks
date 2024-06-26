package com.skyline.notes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.skyline.notes.di.ViewModelFactory
import com.skyline.notes.ui.note.NoteScreen
import com.skyline.notes.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApp).appComponent.inject(this)

        val viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        setContent {
            NoteScreen(viewModel = viewModel)
        }
    }
}