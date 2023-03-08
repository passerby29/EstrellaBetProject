package esterella.cheeseit.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import esterella.cheeseit.data.impls.MainRepositoryImpl
import esterella.cheeseit.domain.usecases.GetInternationalTestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InternationalViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepositoryImpl(application)

    private val getInternationalTestUseCase = GetInternationalTestUseCase(repository)

    private val _countOfRightAnswers = MutableLiveData<String>()
    val countOfRightAnswers: LiveData<String>
        get() = _countOfRightAnswers

    fun getInternationalTest() = viewModelScope.launch(Dispatchers.IO) {
        getInternationalTestUseCase.getInternationalTest()
    }
}
