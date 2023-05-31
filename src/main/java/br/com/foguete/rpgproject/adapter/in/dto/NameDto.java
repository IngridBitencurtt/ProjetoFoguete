package br.com.foguete.rpgproject.adapter.in.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class NameDto {

    @NotBlank
    public String name;

    public String getName() {
        return name;
    }

    public NameDto setName(String name) {
        this.name = name;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameDto nameDto = (NameDto) o;
        return name.equals(nameDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
