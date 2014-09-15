/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.ext.git.server;

import com.codenvy.api.core.util.LineConsumer;
import com.codenvy.ide.ext.git.shared.GitUser;

import java.io.File;

/** @author andrew00x */
public abstract class GitConnectionFactory {
    /**
     * Get connection to Git repository located in <code>workDir</code>.
     *
     * @param workDir
     *         repository directory
     * @param user
     *         user
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public final GitConnection getConnection(String workDir, GitUser user) throws GitException {
        return getConnection(new File(workDir), user, LineConsumer.DEV_NULL);
    }

    /**
     * Get connection to Git repository located in <code>workDir</code>
     *
     * @param workDir
     *         repository directory
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public final GitConnection getConnection(String workDir) throws GitException {
        return getConnection(new File(workDir));
    }

    /**
     * Get connection to Git repository located in <code>workDir</code>.
     *
     * @param workDir
     *         repository directory
     * @param user
     *         user
     * @param outputPublisher
     *         consumer for git output
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public final GitConnection getConnection(String workDir, GitUser user, LineConsumer outputPublisher) throws GitException {
        return getConnection(new File(workDir), user, outputPublisher);
    }

    /**
     * Get connection to Git repository located in <code>workDir</code>
     *
     * @param workDir
     *         repository directory
     * @param outputPublisher
     *         consumer for git output
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public final GitConnection getConnection(String workDir, LineConsumer outputPublisher) throws GitException {
        return getConnection(new File(workDir), outputPublisher);
    }

    /**
     * Get connection to Git repository located in <code>workDir</code>
     *
     * @param workDir
     *         repository directory
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public final GitConnection getConnection(File workDir) throws GitException {
        return getConnection(workDir, LineConsumer.DEV_NULL);
    }

    /**
     * Get connection to Git repository located in <code>workDir</code>.
     *
     * @param workDir
     *         repository directory
     * @param user
     *         user
     * @param outputPublisher
     *         consumer for git output
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public abstract GitConnection getConnection(File workDir, GitUser user, LineConsumer outputPublisher) throws GitException;

    /**
     * Get connection to Git repository locate in <code>workDir</code>
     *
     * @param workDir
     *         repository directory
     * @param outputPublisher
     *         consumer for git output
     * @return connection to Git repository
     * @throws GitException
     *         if can't initialize connection
     */
    public abstract GitConnection getConnection(File workDir, LineConsumer outputPublisher) throws GitException;
}