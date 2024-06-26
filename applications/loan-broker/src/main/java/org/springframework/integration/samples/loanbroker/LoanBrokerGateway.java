/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.samples.loanbroker;

import java.util.List;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.samples.loanbroker.domain.LoanQuote;
import org.springframework.integration.samples.loanbroker.domain.LoanRequest;

/**
 * POJI Gateway that connects method invocations to the request-channel.
 * This completely isolates the developer from Spring Integration API details.
 *
 * @author Oleg Zhurakousky
 * @author Gunnar Hillert
 *
 */
@MessagingGateway
public interface LoanBrokerGateway {


	@Gateway(requestChannel = "loanRequestChannel")
    void processLoanRequest(LoanRequest request);
	/**
	 * Will return the best {@link LoanQuote} for the given request.
	 */
	LoanQuote getBestLoanQuote(LoanRequest loanRequest);

	/**
	 * Will return all {@link LoanQuote}s for the given request.
	 */
	List<LoanQuote> getAllLoanQuotes(LoanRequest loanRequest);

}
