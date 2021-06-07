package com.ankit.storyviewsample.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Color.blue
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ankit.storyviewsample.R
import com.ankit.storyviewsample.models.StoryModel
import com.bumptech.glide.Glide

@SuppressLint("UseCompatLoadingForDrawables")
@RequiresApi(Build.VERSION_CODES.M)
class StoriesAdapter(private var data: ArrayList<StoryModel>, private var context: Context) :
    RecyclerView.Adapter<StoriesAdapter.Viewholder>() {

    private lateinit var model: StoryModel

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgStory: ImageView = itemView.findViewById(R.id.imgStory)
        var progressStory: View = itemView.findViewById(R.id.progressStory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return Viewholder(itemView)
    }


    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        model = data[position]
        Glide.with(context)
            .load(model.imgStory)
            .circleCrop()
            .placeholder(R.drawable.user)
            .into(holder.imgStory)

        holder.imgStory.setOnClickListener {
            holder.progressStory.background=context.resources.getDrawable(R.drawable.story_border,context.theme)

            val rotateAnimation = AnimationUtils.loadAnimation(
                context,
                R.anim.progress
            )
            holder.progressStory.startAnimation(rotateAnimation)
            rotateAnimation.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {
                }


                override fun onAnimationEnd(animation: Animation?) {
                    Toast.makeText(context, "Animation Ended", Toast.LENGTH_SHORT).show()
                    holder.progressStory.background=context.resources.getDrawable(R.drawable.story_border_ended,context.theme)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }

            })
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}