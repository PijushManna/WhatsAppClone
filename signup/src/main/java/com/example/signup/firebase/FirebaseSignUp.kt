package com.example.signup.firebase

//
//class FirebaseSignUp : BaseSignUp(), BaseSignup {
//    private val firebaseAuth = FirebaseAuth.getInstance()
//
//    override fun signup(
//        username: String?,
//        password: String?,
//        email: String?,
//        phone: String?,
//        response: MutableLiveData<APIResponse>
//    ) {
//        response.value =  APIResponse.InProgress
//        if (isValid(username, password, email, phone)) {
//            firebaseAuth.createUserWithEmailAndPassword(email!!, password!!).addOnCompleteListener {
//                if(it.isSuccessful) {
//                    response.postValue(APIResponse.Success(null))
//                }
//                if (it.isCanceled){
//                    response.postValue(APIResponse.Error(Exception("Auth Cancelled")))
//                }
//                if(it.exception != null){
//                    response.postValue(APIResponse.Error(it.exception))
//                }
//            }
//        }else{
//            response.value = APIResponse.Error(Exception("Invalid Credentials"))
//        }
//
//    }
//
//    override fun deleteAccount() {
//        TODO("Not yet implemented")
//    }
//
//}