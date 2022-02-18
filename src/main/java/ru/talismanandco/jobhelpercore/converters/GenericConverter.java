package ru.talismanandco.jobhelpercore.converters;

public interface GenericConverter<T,S> {
    S convert(T t);
}
