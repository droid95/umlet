package com.baselet.element.facet.specific.sequence_aio;

import com.baselet.control.basics.Line1D;
import com.baselet.control.basics.SortedMergedLine1DList;

public class DrawingInfoImpl implements DrawingInfo {

	// private final LifelineHorizontalDrawingInfo[] horizontalDrawingInfos;
	private final HorizontalDrawingInfo horizontalDrawingInfo;
	private final SortedMergedLine1DList[] interruptedAreas;
	private final VerticalDrawingInfo verticalDrawingInfo;

	public DrawingInfoImpl(HorizontalDrawingInfo horizontalDrawingInfo, VerticalDrawingInfo verticalDrawingInfo,
			int lifelineCount) {
		super();
		this.horizontalDrawingInfo = horizontalDrawingInfo;
		interruptedAreas = new SortedMergedLine1DList[lifelineCount];
		for (int i = 0; i < interruptedAreas.length; i++) {
			interruptedAreas[i] = new SortedMergedLine1DList();
		}
		this.verticalDrawingInfo = verticalDrawingInfo;
	}

	@Override
	public LifelineHorizontalDrawingInfo getHDrawingInfo(Lifeline lifeline) {
		return horizontalDrawingInfo.getHDrawingInfo(lifeline);
	}

	@Override
	public double getSymmetricWidthTo(Lifeline ll1, Lifeline ll2, int tick) {
		return horizontalDrawingInfo.getSymmetricWidthTo(ll1, ll2, tick);
	}

	@Override
	public LifelineDrawingInfo getDrawingInfo(Lifeline lifeline) {
		return new LifelineDrawingInfoProxy(lifeline);
	}

	private SortedMergedLine1DList getInterruptedAreas(int lifelineIndex) {
		return interruptedAreas[lifelineIndex];
	}

	@Override
	public double getVerticalHeadStart() {
		return verticalDrawingInfo.getVerticalHeadStart();
	}

	@Override
	public double getVerticalHeadEnd() {
		return verticalDrawingInfo.getVerticalHeadEnd();
	}

	@Override
	public double getHeadHeight() {
		return verticalDrawingInfo.getHeadHeight();
	}

	@Override
	public double getVerticalStart(int tick) {
		return verticalDrawingInfo.getVerticalStart(tick);
	}

	@Override
	public double getVerticalEnd(int tick) {
		return verticalDrawingInfo.getVerticalEnd(tick);
	}

	@Override
	public double getVerticalCenter(int tick) {
		return verticalDrawingInfo.getVerticalCenter(tick);
	}

	@Override
	public double getTickHeight(int tick) {
		return verticalDrawingInfo.getTickHeight(tick);
	}

	@Override
	public double getTickVerticalPadding() {
		return verticalDrawingInfo.getTickVerticalPadding();
	}

	private class LifelineDrawingInfoProxy implements LifelineDrawingInfo {

		private final Lifeline lifeline;

		public LifelineDrawingInfoProxy(Lifeline lifeline) {
			super();
			this.lifeline = lifeline;
		}

		@Override
		public double getHorizontalStart() {
			return getHDrawingInfo(lifeline).getHorizontalStart();
		}

		@Override
		public double getHorizontalEnd() {
			return getHDrawingInfo(lifeline).getHorizontalEnd();
		}

		@Override
		public double getHorizontalStart(int tick) {
			return getHDrawingInfo(lifeline).getHorizontalStart(tick);
		}

		@Override
		public double getHorizontalEnd(int tick) {
			return getHDrawingInfo(lifeline).getHorizontalEnd(tick);
		}

		@Override
		public double getHorizontalCenter() {
			return getHDrawingInfo(lifeline).getHorizontalCenter();
		}

		@Override
		public double getWidth() {
			return getHDrawingInfo(lifeline).getWidth();
		}

		@Override
		public double getWidth(int tick) {
			return getHDrawingInfo(lifeline).getWidth(tick);
		}

		@Override
		public double getSymmetricHorizontalStart(int tick) {
			return getHDrawingInfo(lifeline).getSymmetricHorizontalStart(tick);
		}

		@Override
		public double getSymmetricHorizontalEnd(int tick) {
			return getHDrawingInfo(lifeline).getSymmetricHorizontalEnd(tick);
		}

		@Override
		public double getSymmetricWidth(int tick) {
			return getHDrawingInfo(lifeline).getSymmetricWidth(tick);
		}

		@Override
		public double getVerticalHeadStart() {
			return verticalDrawingInfo.getVerticalHeadStart();
		}

		@Override
		public double getVerticalHeadEnd() {
			return verticalDrawingInfo.getVerticalHeadEnd();
		}

		@Override
		public double getHeadHeight() {
			return verticalDrawingInfo.getHeadHeight();
		}

		@Override
		public double getVerticalStart(int tick) {
			return verticalDrawingInfo.getVerticalStart(tick);
		}

		@Override
		public double getVerticalEnd(int tick) {
			return verticalDrawingInfo.getVerticalEnd(tick);
		}

		@Override
		public double getVerticalCenter(int tick) {
			return verticalDrawingInfo.getVerticalCenter(tick);
		}

		@Override
		public double getTickHeight(int tick) {
			return verticalDrawingInfo.getTickHeight(tick);
		}

		@Override
		public double getTickVerticalPadding() {
			return verticalDrawingInfo.getTickVerticalPadding();
		}

		@Override
		public SortedMergedLine1DList getInterruptedAreas() {
			return DrawingInfoImpl.this.getInterruptedAreas(lifeline.getIndex());
		}

		@Override
		public void addInterruptedArea(Line1D llInterruption) {
			getInterruptedAreas().add(llInterruption);
		}

	}
}
