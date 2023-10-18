package com.example.midtermproject.model

import androidx.lifecycle.ViewModel

class ViewModelShared : ViewModel(){ //shares the value of attempts between the attempt fragment and the game screen fragment
    var attemptCount : String = ""
}