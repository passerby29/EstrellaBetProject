package esterella.cheeseit.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import esterella.cheeseit.data.impls.MainRepositoryImpl
import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.domain.usecases.GetEPLTestUseCase
import esterella.cheeseit.domain.usecases.GetEuropeTestUseCase
import esterella.cheeseit.domain.usecases.GetInternationalTestUseCase
import esterella.cheeseit.domain.usecases.GetWorldTestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepositoryImpl(application)

    private val getInternationalTestUseCase = GetInternationalTestUseCase(repository)
    private val getEPLTestUseCase = GetEPLTestUseCase(repository)
    private val getEuropeTestUseCase = GetEuropeTestUseCase(repository)
    private val getWorldTestUseCase = GetWorldTestUseCase(repository)

    private val _countOfRightAnswers = MutableLiveData<Int>()
    val countOfRightAnswers: LiveData<Int>
        get() = _countOfRightAnswers

    private val _countOfQuestions = MutableLiveData<Int>()
    val countOfQuestions: LiveData<Int>
        get() = _countOfQuestions

    private val _test = MutableLiveData<List<Main>>()
    val test: LiveData<List<Main>>
        get() = _test

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    val selectedButton = MutableLiveData<Int>()

    private var questionId = 1
    private var answers = 0

    fun getInternationalTest() = viewModelScope.launch(Dispatchers.IO) {
        val test = getInternationalTestUseCase.getInternationalTest(questionId)
        _test.postValue(test)
    }

    fun getEPLTest() = viewModelScope.launch(Dispatchers.IO) {
        val test = getEPLTestUseCase.getEPLTest(questionId)
        _test.postValue(test)
    }

    fun getEuropeTest() = viewModelScope.launch(Dispatchers.IO) {
        val test = getEuropeTestUseCase.getEuropeTest(questionId)
        _test.postValue(test)
    }

    fun getWorldTest() = viewModelScope.launch(Dispatchers.IO) {
        val test = getWorldTestUseCase.getWorldTest(questionId)
        _test.postValue(test)
    }

    fun checkAnswer() {
        if (_test.value?.get(selectedButton.value!!)?.mResult == 1) {
            if (answers < 5) {
                ++answers
                _countOfRightAnswers.value = answers
            }
        }
        if (questionId < 5) {
            questionId++
            _countOfQuestions.value = questionId
        } else if (questionId == 5) {
            finishWork()
        }
        getInternationalTest()
    }

    private fun finishWork() {
        _shouldCloseScreen.postValue(Unit)
    }
}
