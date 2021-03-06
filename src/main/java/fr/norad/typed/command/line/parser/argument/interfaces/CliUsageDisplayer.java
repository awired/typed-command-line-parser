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
package fr.norad.typed.command.line.parser.argument.interfaces;

import java.io.PrintStream;
import fr.norad.typed.command.line.parser.argument.CliArgumentManager;

public interface CliUsageDisplayer {

    void setUsageShort(boolean usageShort);

    boolean isUsageShort();

    void displayUsage(CliArgumentManager manager, PrintStream output);

    void displayInfo(CliArgumentManager manager, PrintStream output);

}
