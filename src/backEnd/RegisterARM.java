package backEnd;

public enum RegisterARM {
    R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, SP, LR, PC,
    CPSR, SPSR

}

/*
    R0 - R12: general-purpose registers to hold either data or address clause
    R13 (SP): Stack Pointer
    R14 (LR): Link Registers
    R15 (PC): Program Counter (word-aligned)
    CPSR    : Current Program Status Registers. Contain condition code flags, status bits and current mode bits.
    SPSR    : Saved Program Status Registers. Contains the condition code flags, status bits and current mode bits.
     */