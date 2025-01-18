package com.spikart.back.request;

public class RatingRequest {
    private Long productId;
    private double rating;

    public Long getProductId() {
        return productId;
    }

    public RatingRequest() {

    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
