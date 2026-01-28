# gui.Labyrinth
## gui.Labyrinth exists of
- gui.Cell
  - Obstacle(X)
  - Path (Solution) (*)
  - Start (S)
  - Goal (G)
  - Empty (_)
  - (DEBUG (?))

## DFS (Depth First Search - Tiefensuche)
- Start
- Immer das linkeste

### Code
1. get current location
2. ask: are you the goal
   1. -> yes: done
   