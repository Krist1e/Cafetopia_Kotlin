package by.bsuir.cafetopia.repository.implementations

import by.bsuir.cafetopia.dto.CafeDto
import by.bsuir.cafetopia.repository.CafeRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FirestoreCafeRepository @Inject constructor(
    firestore: FirebaseFirestore
) : CafeRepository {
    private val _cafesCollection = firestore.collection("cafes")

    override fun getCafes(): Flow<List<CafeDto>> = _cafesCollection.dataObjects()
}