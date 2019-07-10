# ResearchSatSolver
This is my repository for exploring the [SAT problem](https://en.wikipedia.org/wiki/Boolean_satisfiability_problem). My aim is to explore the existing heuristics for solving SAT, and their effect on the computational complexity of finding a solution. In addition, this project can also be used as a teaching tool to understand (and potentially illustrate) the Boolean SAT problem.

The solver is written in Java and has been built from scratch. It will solve SAT formulas under the assumption that they are input in [Conjunctive Normal Form](https://en.wikipedia.org/wiki/Conjunctive_normal_form).


## My Process 
Below is a basic outline of my plan for implementation, to keep me on track as I go

1. Preliminary Research  
   _Completed 10/7/19_  

2. Bespoke classes and Parser  
   _In Progress_  

3. Implement Depth First Search to find solution

4. Implement [DPLL Algorithm](https://en.wikipedia.org/wiki/DPLL_algorithm) to find solution

5. Implement [VSIDS](https://arxiv.org/abs/1506.08905) Heuristic

6. Implement [Jeroslow-Wang](https://www.uio.no/studier/emner/matnat/ifi/INF3170/v10/undervisningsmateriale/forelesning12multi.pdf) Heuristic (slide 49)

7. Implement [MOM (Max Occurence Minimum Size)](http://www.cs.toronto.edu/~stefan/publications/classes/cse573/sat.ps) Heuristic

8. Build basic GUI


## Resources (Incomplete)

- [Finding Heuristics](https://www.cs.cmu.edu/~emc/15-820A/reading/sat_cmu.pdf)
- [Explaining Heuristics](http://users.cecs.anu.edu.au/~anbu/papers/IJCAI97Anbulagan.pdf)
- [VSIDS](https://arxiv.org/pdf/1506.08905.pdf)
