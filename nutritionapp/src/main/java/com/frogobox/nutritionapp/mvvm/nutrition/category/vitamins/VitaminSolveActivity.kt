package com.frogobox.nutritionapp.mvvm.nutrition.category.vitamins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityVitaminSolveBinding
import com.frogobox.nutritionapp.util.Constant

class VitaminSolveActivity : BaseActivity<ActivityVitaminSolveBinding>() {

    override fun setupViewBinding(): ActivityVitaminSolveBinding {
        return ActivityVitaminSolveBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_VITAMIN_SOLVE)
    }
}