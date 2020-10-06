/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.atlas.web.rest;
import org.apache.atlas.AtlasErrorCode;
import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.utils.AtlasPerfTracer;
import org.apache.atlas.web.util.Servlets;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * REST for a single entity
 */
@Path("v2/entityIcons")
@Singleton
@Service
@Consumes({Servlets.JSON_MEDIA_TYPE, MediaType.APPLICATION_JSON})
@Produces({Servlets.JSON_MEDIA_TYPE, MediaType.APPLICATION_JSON})
public class EntityIconREST {
    private static final Logger PERF_LOG = AtlasPerfTracer.getPerfLogger("rest.EntityIconREST");

    @Inject
    public EntityIconREST() {
    }

    @GET
    public List<String> getIcons(@Context HttpServletRequest httpServletRequest) throws AtlasBaseException {
        AtlasPerfTracer perf = null;
        try {
            if (AtlasPerfTracer.isPerfTraceEnabled(PERF_LOG)) {
                perf = AtlasPerfTracer.getPerfTracer(PERF_LOG, "EntityIconREST.getIcons()");
            }
            try {
                return Files.list(Paths.get(httpServletRequest.getServletContext()
                    .getRealPath("/n/img/entity-icon/")))
                    .map(java.nio.file.Path::toAbsolutePath)
                    .map(java.nio.file.Path::toFile)
                    .map(File::toString)
                    .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
                throw new AtlasBaseException(AtlasErrorCode.INTERNAL_ERROR, e);
            }
        } finally {
            AtlasPerfTracer.log(perf);
        }
    }

    @GET
    @Path("/realPath")
    public String getRealPath(@Context HttpServletRequest httpServletRequest) throws AtlasBaseException {
        AtlasPerfTracer perf = null;
        try {
            if (AtlasPerfTracer.isPerfTraceEnabled(PERF_LOG)) {
                perf = AtlasPerfTracer.getPerfTracer(PERF_LOG, "EntityIconREST.deleteIcon()");
            }
            return Paths.get(httpServletRequest.getServletContext()
                .getRealPath("/n/img/entity-icon/")).toAbsolutePath().toString();
        } finally {
            AtlasPerfTracer.log(perf);
        }
    }

    @DELETE
    public void deleteIcon(@Context HttpServletRequest httpServletRequest, @RequestParam("file") String fileName) {
        AtlasPerfTracer perf = null;
        try {
            if (AtlasPerfTracer.isPerfTraceEnabled(PERF_LOG)) {
                perf = AtlasPerfTracer.getPerfTracer(PERF_LOG, "EntityIconREST.deleteIcon()");
            }
            File icon = Paths.get(httpServletRequest.getServletContext()
                .getRealPath("/n/img/entity-icon/"), fileName)
                .toFile();
            if (icon.exists()) {
                icon.delete();
            }
        } finally {
            AtlasPerfTracer.log(perf);
        }
    }

    @POST
    public void uploadIcon(@Context HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws AtlasBaseException {
        AtlasPerfTracer perf = null;
        try {
            if (AtlasPerfTracer.isPerfTraceEnabled(PERF_LOG)) {
                perf = AtlasPerfTracer.getPerfTracer(PERF_LOG, "EntityIconREST.uploadIcon()");
            }
            try {
                file.transferTo(Paths.get(httpServletRequest.getServletContext().getRealPath("/n/img/entity-icon/"),
                    file.getName()).toFile());
            } catch (IOException e) {
                e.printStackTrace();
                throw new AtlasBaseException(AtlasErrorCode.INTERNAL_ERROR, e);
            }
        } finally {
            AtlasPerfTracer.log(perf);
        }
    }

}
