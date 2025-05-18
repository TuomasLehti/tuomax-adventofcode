# CPU Class Refactoring Project

## Usage

So far the CPU class has seen use in the following problems:

- Year 2015, day 23 (Opening The Turing Lock)
  - A general cpu simulation with no quirks.
  - Continue execution while the program counter points within the program.
  - Insturctions: half, triple, jump if equal, jump if *one*, jump.
  - Initialize registers to certain values (in part 2).
- Year 2016, day 12 (Leonardo's Monorail) https://adventofcode.com/2016/day/12
  - A general cpu simulation with no quirks.
  - Continue execution while the program counter points within the program.
  - Four registers (a, b, c, d).
  - Instructions: copy, increment, decrement, jump if not zero.
  - Initialize registers to certain values (in part 2).
- Year 2016, day 23 (Safe Cracking) https://adventofcode.com/2016/day/23
  - Togglability of instructions
  - Continue execution while the program counter points within the program.
  - Instructions: copy, increment, decrement, jump if not zero, toggle.
  - Pre parsing needed for part 2 to get a multiply instruction.
- Year 2016, day 25 (Clock Signal)
  - Continue execution while the program counter points within the program.
  - Instructions: copy, increment, decrement, jump if not zero, out.
- Year 2020, day 8 (Handheld Signal) https://adventofcode.com/2020/day/8
  - Needs a method to detect infinite loops.
  - The program should halt while an infinite loop is detected.
  - A concept of an accumulator which is not an register.
- Year 2022, day 10 https://adventofcode.com/2022/day/10
  - A concept of cycles.
  - Needs a way to check the registers after a certain amount of cycles.
  - Continue execution to infinity or to a certain amount of cycles.
  - Instructions: add, nop
- Year 2024, day 17: https://adventofcode.com/2024/day/17
  - Instructions: division, xor, out, set/copy

## Motivation

The CPU class need s thorough refactoring for various reasons.

- Integer overflow. In year 2017, day 18, the values in register outgrew
  the range of an Integer.
- Toggle method is unnecessary for majority of problems. It's extra work to
  keep implementing it for no reason.
- Some problems give a certain set of registers, in others the registers are
  unknown beforehand. This difference in functionality is not present in the
  design of the class at the moment.
- The different methods for stopping the program excecution aren't supported
  and currently need some hacking.
- The general state if instructions is getting worse by the problem. Same
  functionality is present in different places along the directory and class 
  structure.

## Refactoring tasks

- Change the registers to Longs.
- Move the toggling of instructions in 2016d23 to the toggle instruction
  and remove the toggle-method from Instructions.
- Add a constructor to start with an unknown set of registers. Change the
  register getters and setters to add a register and set it to zero, if
  it hasn't been encountered yet.
- Add a possibility to stop the program execution from the cpu and the
  instructions and continue execution later from the same state.
- Move instructions to the framework side if they are general enough.
- Create more general instructions which can be used by InstructionFactories.

## Refactoring instructions

The instructions have a run-method, which takes a cpu.

The instructions should have a getter for the amount of cycles taken by the
execution. The base class should just return zero and the child classes can
override the method when needed.

Everything should be proofed for the future. The main point is that in some
point we may have to deal with memory.

The `acc`-mnemonic from 2020d25 will be implemented with a register called acc.

The table of refactored instructions:

| Year | Day | Mnemonic | Functionality | Instruction class to refactor to
|---|---|---|---|---|
| 2015 | 23 | `hlf reg` | Halfs the value in a register. | DivRegByImm(2) |
| 2015 | 23 | `tpl reg` | Triples the value in a register. | MulRegByImm(3) |
| 2015 | 23 | `inc reg` | Increments the value in a register. | IncRegByImm(1) |
| 2015 | 23 | `jmp imm` | Unconditional relative jump. | RelJmp(ofs) |
| 2015 | 23 | `jie reg imm` | Relative jump if `reg` is even. | RelJmpIfRegEven |
| 2015 | 23 | `jio reg imm` | Relative jump if `reg` is *one*. | RelJmpIfRegEquals(1) |
| 2016 | 12 | `cpy reg/imm reg` | Copies an immediate value or a value of an other register to a register. | CpyImmToReg / CpyRegToReg|
| 2016 | 12 | `inc reg` | Increments the value in a register. | IncRegByImm(1) |
| 2016 | 12 | `dec reg` | Decrements the value in a register. | DecRegByImm(1) |
| 2016 | 12 | `jnz reg/imm imm` | Relative jump if `reg` or an immediate value is zero. | RelJmpIfRegEquals(0) |
| 2016 | 23 | `tgl imm` | Toggles an instruction to another. | (2) |
| 2016 | 25 | `out reg/imm` | Outputs an immediate value or a value of a register. |  |
| 2020 | 25 | `acc imm` | Adds an immediate value to the accumulator. | IncRegByImm(acc, imm) / IncRegByReg(acc, reg) |
| 2020 | 25 | `jmp imm` | Unconditional relative jump. | RelJmp(ofs) |
| 2020 | 25 | `nop` | No operation | Nop() |
| 2022 | 10 | `addx imm` | Adds an immediate value to a specific register. | IncRegByImm("x", imm) |
| 2022 | 10 | `noop` | No operation. | Nop() |
