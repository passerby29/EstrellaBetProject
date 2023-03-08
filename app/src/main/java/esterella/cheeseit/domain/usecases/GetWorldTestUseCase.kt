package esterella.cheeseit.domain.usecases

import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.domain.repos.MainRepository

class GetWorldTestUseCase(private val repository: MainRepository) {

    suspend fun getWorldTest(questionId: Int): List<Main> {
        return repository.getWorldTest(questionId)
    }
}