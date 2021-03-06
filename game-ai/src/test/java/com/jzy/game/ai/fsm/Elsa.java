/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.jzy.game.ai.fsm;

import com.jzy.game.ai.msg.Telegram;
import com.jzy.game.ai.msg.Telegraph;

/** @author davebaol */
public class Elsa implements Telegraph {

	// an instance of the state machine class
	private StateMachine<Elsa, ElsaState> stateMachine;

	// is she presently cooking?
	boolean cooking;

	Bob bob;

	public Elsa () {
		this(null);
	}

	public Elsa (Bob bob) {
		stateMachine = new DefaultStateMachine<Elsa, ElsaState>(this, ElsaState.DO_HOUSE_WORK, ElsaState.GLOBAL_STATE);
		this.bob = bob;
	}

	@Override
	public boolean handleMessage (Telegram msg) {
		return stateMachine.handleMessage(msg);
	}

	public void update (float delta) {
		stateMachine.update();
	}

	public StateMachine<Elsa, ElsaState> getStateMachine () {
		return stateMachine;
	}

	public Bob getBob () {
		return bob;
	}

	public void setBob (Bob bob) {
		this.bob = bob;
	}

	public boolean isCooking () {
		return cooking;
	}

	public void setCooking (boolean cooking) {
		this.cooking = cooking;
	}

}
