package by.bsuir.cafetopia.repository.implementations

import by.bsuir.cafetopia.repository.FavoritesRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreFavoritesRepository @Inject constructor(
    firestore: FirebaseFirestore
) : FavoritesRepository {
    private val _usersCollection = firestore.collection("users")
    override fun getFavorites(userId: String): Flow<List<String>> =
        getFavoritesCollection(userId).snapshots().map { snapshots ->
            snapshots.documents.map { it.id }
        }

    override suspend fun addFavorite(userId: String, cafeId: String) {
        getFavoritesCollection(userId).document(cafeId).set(emptyMap<String, Any>()).await()
    }

    override suspend fun removeFavorite(userId: String, cafeId: String) {
        getFavoritesCollection(userId).document(cafeId).delete().await()
    }

    private fun getFavoritesCollection(userId: String) =
        _usersCollection.document(userId).collection("favorites")
}