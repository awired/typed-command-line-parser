/**
 *
 *     Copyright (C) norad.fr
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package fr.norad.typed.command.line.parser.param;

import java.net.InetAddress;
import java.net.UnknownHostException;
import fr.norad.typed.command.line.parser.argument.CliArgumentParseException;

public class CliParamInetAddress extends CliParam<InetAddress> {

    public CliParamInetAddress(String name) {
        super(name);
    }

    @Override
    public InetAddress parse(String param) throws CliArgumentParseException {
        try {
            return InetAddress.getByName(param);
        } catch (UnknownHostException e) {
            throw new CliArgumentParseException("bad inet address : " + e.getMessage());

        }
    }

}
