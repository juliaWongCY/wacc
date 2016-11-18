package backEnd;

public enum RegisterARM {
    R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, SP, LR, PC,
    CPSR, SPSR

}

/*
    R0 - R12: general-purpose registers to hold either data or address claue
    R13     : Stack Pointer
    R14     : Link Register
    R15     : Program Counter (word-aligned)
    CPSR    : Current Program Status Register. Contain condition code flags, status bits and current mode bits.
    SPSR    : Saved Program Status Register. Contains the condition code flags, status bits and current mode bits.
     */