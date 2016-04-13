package nervig;

import H2.Game;
import H2.GameStrategy;
import H2.Move;

public class MinMaxStrategy implements GameStrategy {
	class MoveValue {
		private Move	m;
		private int		v;

		public MoveValue(Move m, int v) {
			this.m = m;
			this.v = v;
		}

		public Move move() {
			return this.m;
		}

		public int val() {
			return this.v;
		}

		public MoveValue negateValue() {
			this.v = (-this.v);
			return this;
		}
	}

	private MoveValue negamax(Game g) {
		if (g.ended())
			return new MoveValue(null, g.evalState(g.currentPlayer()));
		MoveValue bestMove = new MoveValue(null, Integer.MIN_VALUE);
		for (Move m : g.remainingMoves()) {
			g.doMove(m);
			MoveValue eval = negamax(g).negateValue();
			g.undoMove(m);
			if (eval.val() > bestMove.val())
				bestMove = new MoveValue(m, eval.val());
		}
		return bestMove;
	}

	public Move nextMove(Game g) {
		return negamax(g).move();
	}
}

// Wird in künstliche Intelligenz drauf eingegangen :-):-):-):-):-):-):-):-):-):-):-):-)
// ohne duko.... Leck mich doch mal am Arsch :-):-):-):-):-):-):-):-):-):-):-):-)
