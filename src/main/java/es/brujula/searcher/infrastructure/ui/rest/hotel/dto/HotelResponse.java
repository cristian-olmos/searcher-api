package es.brujula.searcher.infrastructure.ui.rest.hotel.dto;

import es.brujula.searcher.domain.hotel.model.Hotel;
import org.apache.commons.lang3.Validate;
import org.springframework.hateoas.RepresentationModel;

public final class HotelResponse extends RepresentationModel<HotelResponse> {

    private String name;
    private String address;
    private String category;

    private HotelResponse(String name, String address, String category) {
        this.setName(name);
        this.setAddress(address);
        this.setCategory(category);
    }

    public static HotelResponse fromDomain(Hotel hotel) {
        return new HotelResponse(hotel.name(), hotel.address(), hotel.category());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Validate.notBlank(name);
        this.name = name.trim();
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        Validate.notBlank(address);
        this.address = address.trim();
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        Validate.notBlank(category);
        this.category = category.trim();
    }

}
