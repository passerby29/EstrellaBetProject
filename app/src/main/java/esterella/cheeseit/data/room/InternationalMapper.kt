package esterella.cheeseit.data.room

class InternationalMapper {
    fun mapEntityToDbModel() = InternationalEntity()

    fun mapListDbModel(list: List<InternationalEntity>) = list.map {
        mapDbModelToEntity(it)
    }

    private fun mapDbModelToEntity(userEntity: InternationalEntity) = ()
}