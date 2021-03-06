/*
 * IzPack - Copyright 2001-2012 Julien Ponge, All Rights Reserved.
 *
 * http://izpack.org/
 * http://izpack.codehaus.org/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.izforge.izpack.api.exception;

import com.izforge.izpack.api.handler.Prompt;
import com.izforge.izpack.api.handler.Prompt.Type;

/**
 * Izpack specific exception
 *
 * @author Anthonin Bonnefoy
 */
public class IzPackException extends RuntimeException
{
    Prompt.Type promptType = Type.ERROR;

    public IzPackException(String message)
    {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public IzPackException(Throwable cause)
    {
        super(cause);
    }

    public IzPackException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public IzPackException(String message, Prompt.Type promptType)
    {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
        this.promptType = promptType;
    }

    public IzPackException(Throwable cause, Prompt.Type promptType)
    {
        super(cause);
        this.promptType = promptType;
    }

    public IzPackException(String message, Throwable cause, Prompt.Type promptType)
    {
        super(message, cause);
        this.promptType = promptType;
    }

    public Prompt.Type getPromptType()
    {
        return promptType;
    }
}
