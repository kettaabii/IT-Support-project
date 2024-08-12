package com.example.ITsupport.exeption;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(Integer equipmentId) {
        super("Equipment with ID " + equipmentId + " not found.");
    }
}
