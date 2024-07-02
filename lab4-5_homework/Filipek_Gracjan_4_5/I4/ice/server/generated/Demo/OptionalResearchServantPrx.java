//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `researching_optional.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Demo;

public interface OptionalResearchServantPrx extends com.zeroc.Ice.ObjectPrx
{
    default C sendC(C c)
    {
        return sendC(c, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default C sendC(C c, java.util.Map<String, String> context)
    {
        return _iceI_sendCAsync(c, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<C> sendCAsync(C c)
    {
        return _iceI_sendCAsync(c, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<C> sendCAsync(C c, java.util.Map<String, String> context)
    {
        return _iceI_sendCAsync(c, context, false);
    }

    /**
     * @hidden
     * @param iceP_c -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<C> _iceI_sendCAsync(C iceP_c, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<C> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "sendC", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeValue(iceP_c);
                     ostr.writePendingValues();
                 }, istr -> {
                     final com.zeroc.IceInternal.Holder<C> ret = new com.zeroc.IceInternal.Holder<>();
                     istr.readValue(v -> ret.value = v, C.class);
                     istr.readPendingValues();
                     return ret.value;
                 });
        return f;
    }

    default void throwException(boolean withOptional)
        throws MyException
    {
        throwException(withOptional, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void throwException(boolean withOptional, java.util.Map<String, String> context)
        throws MyException
    {
        try
        {
            _iceI_throwExceptionAsync(withOptional, context, true).waitForResponseOrUserEx();
        }
        catch(MyException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> throwExceptionAsync(boolean withOptional)
    {
        return _iceI_throwExceptionAsync(withOptional, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> throwExceptionAsync(boolean withOptional, java.util.Map<String, String> context)
    {
        return _iceI_throwExceptionAsync(withOptional, context, false);
    }

    /**
     * @hidden
     * @param iceP_withOptional -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_throwExceptionAsync(boolean iceP_withOptional, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "throwException", null, sync, _iceE_throwException);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeBool(iceP_withOptional);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_throwException =
    {
        MyException.class
    };

    default int[] sequenceMethod(int[] intArray)
    {
        return sequenceMethod(intArray, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default int[] sequenceMethod(int[] intArray, java.util.Map<String, String> context)
    {
        return _iceI_sequenceMethodAsync(intArray, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<int[]> sequenceMethodAsync(int[] intArray)
    {
        return _iceI_sequenceMethodAsync(intArray, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<int[]> sequenceMethodAsync(int[] intArray, java.util.Map<String, String> context)
    {
        return _iceI_sequenceMethodAsync(intArray, context, false);
    }

    /**
     * @hidden
     * @param iceP_intArray -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<int[]> _iceI_sequenceMethodAsync(int[] iceP_intArray, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<int[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "sequenceMethod", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeIntSeq(iceP_intArray);
                 }, istr -> {
                     int[] ret;
                     ret = istr.readIntSeq();
                     return ret;
                 });
        return f;
    }

    default void voidMethod()
    {
        voidMethod(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void voidMethod(java.util.Map<String, String> context)
    {
        _iceI_voidMethodAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> voidMethodAsync()
    {
        return _iceI_voidMethodAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> voidMethodAsync(java.util.Map<String, String> context)
    {
        return _iceI_voidMethodAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_voidMethodAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "voidMethod", null, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default java.util.OptionalInt optionalParameters(int integer)
    {
        return optionalParameters(integer, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default java.util.OptionalInt optionalParameters(int integer, java.util.Map<String, String> context)
    {
        return _iceI_optionalParametersAsync(integer, context, true).waitForResponse();
    }

    default java.util.OptionalInt optionalParameters(java.util.OptionalInt integer)
    {
        return optionalParameters(integer, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default java.util.OptionalInt optionalParameters(java.util.OptionalInt integer, java.util.Map<String, String> context)
    {
        return _iceI_optionalParametersAsync(integer, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.util.OptionalInt> optionalParametersAsync(int integer)
    {
        return _iceI_optionalParametersAsync(integer, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.util.OptionalInt> optionalParametersAsync(int integer, java.util.Map<String, String> context)
    {
        return _iceI_optionalParametersAsync(integer, context, false);
    }

    /**
     * @hidden
     * @param iceP_integer -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.util.OptionalInt> _iceI_optionalParametersAsync(int iceP_integer, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.util.OptionalInt> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "optionalParameters", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(1, iceP_integer);
                 }, istr -> {
                     java.util.OptionalInt ret;
                     ret = istr.readInt(2);
                     return ret;
                 });
        return f;
    }

    default java.util.concurrent.CompletableFuture<java.util.OptionalInt> optionalParametersAsync(java.util.OptionalInt integer)
    {
        return _iceI_optionalParametersAsync(integer, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.util.OptionalInt> optionalParametersAsync(java.util.OptionalInt integer, java.util.Map<String, String> context)
    {
        return _iceI_optionalParametersAsync(integer, context, false);
    }

    /**
     * @hidden
     * @param iceP_integer -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.util.OptionalInt> _iceI_optionalParametersAsync(java.util.OptionalInt iceP_integer, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.util.OptionalInt> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "optionalParameters", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(1, iceP_integer);
                 }, istr -> {
                     java.util.OptionalInt ret;
                     ret = istr.readInt(2);
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OptionalResearchServantPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), OptionalResearchServantPrx.class, _OptionalResearchServantPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OptionalResearchServantPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), OptionalResearchServantPrx.class, _OptionalResearchServantPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OptionalResearchServantPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), OptionalResearchServantPrx.class, _OptionalResearchServantPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static OptionalResearchServantPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), OptionalResearchServantPrx.class, _OptionalResearchServantPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static OptionalResearchServantPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, OptionalResearchServantPrx.class, _OptionalResearchServantPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static OptionalResearchServantPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, OptionalResearchServantPrx.class, _OptionalResearchServantPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default OptionalResearchServantPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (OptionalResearchServantPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default OptionalResearchServantPrx ice_adapterId(String newAdapterId)
    {
        return (OptionalResearchServantPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default OptionalResearchServantPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (OptionalResearchServantPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default OptionalResearchServantPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (OptionalResearchServantPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default OptionalResearchServantPrx ice_invocationTimeout(int newTimeout)
    {
        return (OptionalResearchServantPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default OptionalResearchServantPrx ice_connectionCached(boolean newCache)
    {
        return (OptionalResearchServantPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default OptionalResearchServantPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (OptionalResearchServantPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default OptionalResearchServantPrx ice_secure(boolean b)
    {
        return (OptionalResearchServantPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default OptionalResearchServantPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (OptionalResearchServantPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default OptionalResearchServantPrx ice_preferSecure(boolean b)
    {
        return (OptionalResearchServantPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default OptionalResearchServantPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (OptionalResearchServantPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default OptionalResearchServantPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (OptionalResearchServantPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default OptionalResearchServantPrx ice_collocationOptimized(boolean b)
    {
        return (OptionalResearchServantPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default OptionalResearchServantPrx ice_twoway()
    {
        return (OptionalResearchServantPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default OptionalResearchServantPrx ice_oneway()
    {
        return (OptionalResearchServantPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default OptionalResearchServantPrx ice_batchOneway()
    {
        return (OptionalResearchServantPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default OptionalResearchServantPrx ice_datagram()
    {
        return (OptionalResearchServantPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default OptionalResearchServantPrx ice_batchDatagram()
    {
        return (OptionalResearchServantPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default OptionalResearchServantPrx ice_compress(boolean co)
    {
        return (OptionalResearchServantPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default OptionalResearchServantPrx ice_timeout(int t)
    {
        return (OptionalResearchServantPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default OptionalResearchServantPrx ice_connectionId(String connectionId)
    {
        return (OptionalResearchServantPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default OptionalResearchServantPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (OptionalResearchServantPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::Demo::OptionalResearchServant";
    }
}
