package esterella.cheeseit.domain.repos

import esterella.cheeseit.domain.models.International

interface MainRepository {

    suspend fun getInternationalTest(): List<International>
}