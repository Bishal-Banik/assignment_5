package com.rkcorner.assignment_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    private Context context;
    private List<Pet> petList;

    public PetAdapter(Context context, List<Pet> petList) {
        this.context = context;
        this.petList = petList;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.pet_item, parent, false);
        return new PetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        Pet pet = petList.get(position);

        // Initial setup for the first image, name, and age
        holder.petImage.setImageResource(pet.getImage(0));
        holder.petName.setText(pet.getName(0));
        holder.petAge.setText(pet.getAge(0));
        holder.petBreed.setText(pet.getBreed());
        holder.petType.setText(pet.getType());

        // Handle "Change Picture" button click
        holder.changePictureButton.setOnClickListener(v -> {
            // Update to the next image, name, and age
            int nextIndex = (holder.currentIndex + 1) % pet.getImageCount(); // Cycle through images
            holder.currentIndex = nextIndex;

            // Use slide animation
            animateSlideTransition(holder, pet, nextIndex);
        });
    }

    private void animateSlideTransition(PetViewHolder holder, Pet pet, int currentIndex) {
        // Create the slide animation (from the XML we created)
        Animation slideAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left);

        // Start the animation for pet's image, name, and age
        holder.petImage.startAnimation(slideAnimation);
        holder.petName.startAnimation(slideAnimation);
        holder.petAge.startAnimation(slideAnimation);

        // Update the views after the animation starts (this will happen in the next frame)
        holder.petImage.setImageResource(pet.getImage(currentIndex)); // Change image
        holder.petName.setText(pet.getName(currentIndex)); // Change name
        holder.petAge.setText(pet.getAge(currentIndex)); // Change age

        // Ensure the views don't overlap while transitioning
        slideAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Do nothing here
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // After the animation ends, finalize the view updates
                holder.petImage.setImageResource(pet.getImage(currentIndex));
                holder.petName.setText(pet.getName(currentIndex));
                holder.petAge.setText(pet.getAge(currentIndex));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Do nothing here
            }
        });
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    // PetViewHolder to bind data
    public static class PetViewHolder extends RecyclerView.ViewHolder {
        ImageView petImage;
        TextView petName, petBreed, petAge, petType;
        Button changePictureButton;
        int currentIndex = 0;  // Index to track the current image

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.pet_image);
            petName = itemView.findViewById(R.id.pet_name);
            petBreed = itemView.findViewById(R.id.pet_breed);
            petAge = itemView.findViewById(R.id.pet_age);
            petType = itemView.findViewById(R.id.pet_type);
            changePictureButton = itemView.findViewById(R.id.change_picture_button);
        }
    }
}
