package esterella.cheeseit.data.room

import esterella.cheeseit.domain.models.International

class InternationalMapper {
    fun mapEntityToDbModel(test: International) = InternationalEntity(
        mId = test.mId,
        mQuestion = test.mQuestion,
        mAnswer = test.mAnswer,
        mResult = test.mResult,
    )

    fun mapListDbModel(list: List<InternationalEntity>) = list.map {
        mapDbModelToEntity(it)
    }

    private fun mapDbModelToEntity(internationalEntity: InternationalEntity) = International(
        mId = internationalEntity.mId,
        mQuestion = internationalEntity.mQuestion,
        mAnswer = internationalEntity.mAnswer,
        mResult = internationalEntity.mResult,
    )
}